package co.zsmb.rainbowcake.guardiandemo.ui.list

import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException

class ListViewModel @ViewModelInject constructor(
    private val listPresenter: ListPresenter
) : RainbowCakeViewModel<ListViewState>(Loading) {

    init {
        execute { loadNews() }
    }

    fun reload() {
        execute { loadNews() }
    }

    private suspend fun loadNews() {
        viewState = Loading
        viewState = try {
            val items = listPresenter.getNewsItems()
            ListReady(items)
        } catch (e: IOException) {
            NetworkError
        }
    }

}
