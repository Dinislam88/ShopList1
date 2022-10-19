package com.example.shoplist1.presentation

import androidx.lifecycle.ViewModel
import com.example.shoplist1.data.ShopListRepositoryImpl
import com.example.shoplist1.domain.DeleteShopItemUseCase
import com.example.shoplist1.domain.EditShopItemUseCase
import com.example.shoplist1.domain.GetShopListUseCase
import com.example.shoplist1.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}