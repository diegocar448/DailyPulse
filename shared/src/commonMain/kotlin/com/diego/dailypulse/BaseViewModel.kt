package com.diego.dailypulse

import kotlinx.coroutines.CoroutineScope

//Ao usar open na classe significa que a classe não é final e as outras são livres
expect open class BaseViewModel  {

    val scope: CoroutineScope
}