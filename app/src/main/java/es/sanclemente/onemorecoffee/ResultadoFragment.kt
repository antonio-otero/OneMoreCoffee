package es.sanclemente.onemorecoffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import es.sanclemente.onemorecoffee.databinding.FragmentResultadoBinding

class ResultadoFragment : Fragment() {

    private val args: ResultadoFragmentArgs by navArgs()

    private var _binding: FragmentResultadoBinding? = null
    private val binding get() = checkNotNull(_binding) {
        "No se puede acceder al binding porque es nulo. ¿Está visible la vista?"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recomendacions = Cafeteria.recomendacions(args.tipo)
        val nomeTipo       = resources.getStringArray(R.array.tipos_cafe)[args.tipo]

        binding.ivTipo.setImageResource(Cafeteria.imaxeTipo(args.tipo))

        binding.lvResultado.adapter = ArrayAdapter(
            requireContext(),
            R.layout.fila_cafe,
            recomendacions.map { it.nome }
        )

        binding.tvCabeceira.text = resources.getQuantityString(
            R.plurals.recomendacions,
            recomendacions.size,
            recomendacions.size,
            nomeTipo
        )

        binding.lvResultado.setOnItemClickListener { _, _, posicion, _ ->
            val accion = ResultadoFragmentDirections.accionResultadoADetalle(
                tipo = args.tipo,
                indice = posicion
            )
            findNavController().navigate(accion)
        }

        binding.tvCuriosidade.text = resources.getStringArray(R.array.curiosidades).random()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
