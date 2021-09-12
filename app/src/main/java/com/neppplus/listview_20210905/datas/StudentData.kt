package com.neppplus.listview_20210905.datas

class StudentData(
    val name: String,
    val birthYear: Int,
    val address: String) {


//    이 사람의 나이를 계산해주는 기능
//    연도를 넣으면 > 그 해의 나이를 계산

    fun getKoreaAge( year: Int ) : Int {

//    해당 연도의 한국 나이 계산
        val koreanAge = year - this.birthYear + 1

//        koreanAge가 최종 결과라고 지정.
        return koreanAge
    }

}