package com.neppplus.listview_20210905.adapters

import android.content.Context
import android.content.LocusId
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.listview_20210905.R
import com.neppplus.listview_20210905.datas.StudentData
import org.w3c.dom.Text

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext, resId, mList){


//    한 줄 xml + StudentData 클래스의 정보 결합 → 리스트뷰의 각 자리에 뿌려주자
//    xml로 그려둔 한 줄 모양을 → Kotlin 안에서 활용할 수 있어야함
//    활용을 도와주는 도구도 필요하다.

    val mInflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null){
            tempRow = mInflater.inflate(R.layout.student_list_item,  null)
        }

//        tempRow는 절대 null일 가능성이 없다 > 진짜 row로 옮겨담자
        val row = tempRow!!


//        row가 결과로 나가기 전에 > 내부에 있는 텍스트뷰들을, 실제 데이터에 맞게 문구 변경.
//        최종 가공 후에 결과로 나가자

//        position의 값 : 위치에 맞게 데이터가, 누구의 데이터인지? 가져오자
        val data = mList[position]

//        row의 내부에서, 필요한 텍스트뷰 등 UI요소들을 가져오자.
        val nameTxt = row.findViewById<TextView>( R.id.nameTxt )
        val adressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        nameTxt.text = data.name
        adressTxt.text = data.address

//        ageTxt에는, 출생년도가 아니라 나이가 들어가야함
//        출생년도로 나이를 계산하는 로직은 어떻게되는가? → 자바 기초 / 파이썬 기초 > 언어 역량
        val age = 2021 - data.birthTear +1

        ageTxt.text = "(${age}세)"




//        만들어진 row를 getView 작업의 결과물로 지정.

        return row


    }


}