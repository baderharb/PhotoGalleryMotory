package baderharb.motory.photogallerymotory.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import baderharb.motory.photogallerymotory.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var viewBinding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private val adapter: CategoryAdapter by inject()
    private val photoAdapter: PhotoAdapter by inject()
    private var isOneColumn = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.isOneColumn = isOneColumn
        viewBinding.photosRc.layoutManager = LinearLayoutManager(context)

        viewBinding.oneColumnImg.setOnClickListener {
            if (isOneColumn) {
                return@setOnClickListener
            }
            isOneColumn = !isOneColumn
            viewBinding.isOneColumn = isOneColumn
            viewBinding.photosRc.layoutManager = LinearLayoutManager(context)
        }
        viewBinding.twoColumnImg.setOnClickListener {
            if (!isOneColumn) {
                return@setOnClickListener
            }
            isOneColumn = !isOneColumn
            viewBinding.isOneColumn = isOneColumn
            viewBinding.photosRc.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        viewBinding.categoryRc.adapter = adapter
        viewBinding.photosRc.adapter = photoAdapter

        viewModel.message.observe(viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.categories.observe(viewLifecycleOwner, {
            adapter.clear()
            adapter.setItems(it)
        })
        viewModel.photos.observe(viewLifecycleOwner, {
            photoAdapter.clear()
            it?.let { it1 -> photoAdapter.setItems(it1) }
        })
    }
}