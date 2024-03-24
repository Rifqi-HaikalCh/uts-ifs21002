package com.ifs21002.dinopedia
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21002.dinopedia.databinding.ItemRowDinoBinding

class ListUnitAdapter(private val listDino: ArrayList<Unit>) : RecyclerView.Adapter<ListUnitAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: ListUnitAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: ListUnitAdapter.OnItemClickCallback
    ) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUnitAdapter.ListViewHolder {
        val binding =ItemRowDinoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ListViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListUnitAdapter.ListViewHolder, position: Int) {
        val dino = listDino[position]
        holder.binding.ivItemDino.setImageResource(dino.icon)
        holder.binding.tvItemDino.text = dino.name
        holder.binding.tvItemsDino.text = dino.name
        holder.itemView.setOnClickListener {
            onItemClickCallback
                .onItemClicked(listDino[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listDino.size

    class ListViewHolder(var binding: ItemRowDinoBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Unit)
    }
}