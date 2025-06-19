//package com.example.shopping_events_app.ui.home
//
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//
//@Composable
//fun TelaA(modifier: Modifier = Modifier) {
//    Button(
//        onClick = {
//            TelaB(
//                args = it.id
//            )
//        }
//    ) { }
//}
//
//
//
//@Composable
//fun TelaB(modifier: Modifier = Modifier, args: TelaBArgs) {
//    Text()
//}
//
//class TelaBViewModel(
//    savedStateHandle: SavedStateHandle
//): ViewModel(){
//    TelaB.argsFrom(savedStateHandle)
//}
//
//data class TelaBArgs(
//    val id: Int
//)