package com.example.practicaimagefilterviewtransiciondeimagen

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaimagefilterviewtransiciondeimagen.databinding.FragmentContactFragmentBinding
import androidx.core.util.Pair

class contact_fragment : Fragment() {

    private var _binding: FragmentContactFragmentBinding? = null
    lateinit var list: MutableList<Item>
    lateinit var recycler: RecyclerView

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        list = mutableListOf<Item>(
            Item("PPPP", "descripcion descriptiva 1"),
            Item("Zalt", "descripcion descriptiva 12"),
            Item("Juan", "descripcion descriptiva 123"),
            Item("Ramiro", "descripcion descriptiva 1234"),
            Item("Lola", "descripcion descriptiva 12345"),
            Item("Chema", "descripcion descriptiva 123456")
        )

        var adapter =
            this.context?.let { AdapterRv(list, it) { name -> onClick(name) } }
        val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        val galleryViewModel =
            ViewModelProvider(this).get(ContactViewModel::class.java)
        _binding = FragmentContactFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recycler = binding.rvContact
        galleryViewModel.text.observe(viewLifecycleOwner)
        {
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            recycler.addItemDecoration(divider)
        }

        return root
    }

    fun onClick(name: View){

            val item = list.get(recycler.getChildAdapterPosition(name))
            val p1 = Pair.create<View, String>(name, name.transitionName)
            val options = this.activity?.let {
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    it,
                    p1
                ).toBundle()
            }
            val inten = Intent(this.context, com.example.practicaimagefilterviewtransiciondeimagen.Result::class.java)
            options?.putString("name", item.name)
            options?.putString("Transitionname", name.transitionName)
            options?.putString("description", item.description)

            inten.putExtras(options!!)
            startActivity(inten,options)

    }



}