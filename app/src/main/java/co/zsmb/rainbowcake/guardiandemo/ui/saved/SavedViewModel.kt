package co.zsmb.rainbowcake.guardiandemo.ui.saved

import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import kotlinx.coroutines.flow.collect

class SavedViewModel @ViewModelInject constructor(
    private val savedPresenter: SavedPresenter
) : RainbowCakeViewModel<SavedViewState>(Loading) {

    init {
        executeNonBlocking {
            savedPresenter.getSavedNews().collect { news ->
                viewState = if (news.isEmpty()) {
                    Empty
                } else {
                    SavedReady(news)
                }
            }
        }
    }

}
