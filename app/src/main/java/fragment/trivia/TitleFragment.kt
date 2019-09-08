package fragment.trivia


import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.kotlin_fundamental.R
import com.example.android.kotlin_fundamental.databinding.FragmentTitleBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    // アクティビティに関連づけられたタイミングで呼び出される
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.i("onAttach called")
    }

    // ActivityのonCreateとほぼ同様
    // 別のFragmentに表示が切り替わり、戻って再表示されるタイミングでは呼び出されない
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
    }

    // Fragmentのレイアウトをinflateするために呼び出される
    // 別のFragmentに表示が切り替わり、戻って再表示されるタイミングでも呼び出される
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)

        binding.playButton.setOnClickListener { view ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        setHasOptionsMenu(true)

        Timber.i( "onCreateView called")

        return binding.root
    }

    // ActivityのonCreateが完了した時に呼び出される
    // このタイミング以降からActivityに触れるようになる
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated called")
    }

    // Fragmentが表示される際に呼び出される
    // ActivityのonStartとほぼ同様
    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }

    // Fragmentがユーザーフォーカスを取得すると呼び出される
    // ActivityのonResumeとほぼ同様
    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }

    // Fragmentがユーザーフォーカスを失うと呼び出される
    // ActivityのonPauseとほぼ同様
    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }

    // Fragmentが画面に表示されなくなった時呼び出される
    // ActivityのonStopとほぼ同様
    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    // FragmentのViewが不要になったタイミングで呼ばれる
    // 別のFragmentに表示が切り替わったりするタイミングでも呼び出される
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy called")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach called")
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}
