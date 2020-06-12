package co.zsmb.rainbowcake.guardiandemo.data.disk

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DiskModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, "news.db").build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao()

}
