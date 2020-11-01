package com.malikov.finapp.ui.`object`

import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import com.malikov.finapp.R
import com.malikov.finapp.utils.APP_ACTIVITY
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem


class AppDrawer {
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mCurrentProfile: ProfileDrawerItem


    fun create() {
        createHeader()
        createDrawer()
        mDrawerLayout = mDrawer.drawerLayout
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(APP_ACTIVITY)
            .withToolbar(APP_ACTIVITY.mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Инвестиции")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_invest),
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Активы")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_active),
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Рекомендаци")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_recommended),
                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Валюта")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_currency)
                    .withSetExpanded(true),
                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Тема")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_theme),
                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Избранное")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_star),
                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Язык")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_language),
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName("Удалить данные")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_delete),
                PrimaryDrawerItem().withIdentifier(109)
                    .withIconTintingEnabled(true)
                    .withName("Вопросы о FinApp")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_question)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    clickToItem(position)
                    return false
                }
            }).build()

    }

    private fun clickToItem(position: Int) {
        when (position) {
            7 -> APP_ACTIVITY.mAlert.createLanguage()
        }
    }





private fun createHeader() {
    mCurrentProfile = ProfileDrawerItem()
        .withName("Ваше имя")
    mHeader = AccountHeaderBuilder()
        .withActivity(APP_ACTIVITY)
        .withHeaderBackground(R.drawable.header)
        .withCloseDrawerOnProfileListClick(true)
        .withProfileImagesVisible(false)
        .addProfiles(
            mCurrentProfile
        ).build()

}
}