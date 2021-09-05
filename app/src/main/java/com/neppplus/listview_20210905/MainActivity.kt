package com.neppplus.listview_20210905

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.neppplus.listview_20210905.adapters.StudentAdapter
import com.neppplus.listview_20210905.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

//    변수만 만들고, 대입은 나중에 하겠다 > lateinit var
    lateinit var mAdapter: StudentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        임시방편 : 코드에 타이핑해서, 학생 데이터 추가.

        mStudentList.add(StudentData("이진호",1991,"서울시 동대문구"))
        mStudentList.add(StudentData("조경진",1988,"서울시 동대문구"))
        mStudentList.add(StudentData("김기만",1972,"서울시 성북구"))
        mStudentList.add(StudentData("김성은",1992,"서울시 중랑구"))
        mStudentList.add(StudentData("박광현",1995,"서울시 동작구"))
        mStudentList.add(StudentData("유순정",1992,"서울시 중랑구"))
        mStudentList.add(StudentData("이승엽",1993,"경기도 고양시"))
        mStudentList.add(StudentData("전상효",1992,"서울시 구로구"))
        mStudentList.add(StudentData("차수나",1966,"서울시 동대문구"))
        mStudentList.add(StudentData("김다은",1992,"서울시 동대문구"))

//        미뤄놨던 mAdapter의 대입을 해주자
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

//        리스트뷰의 어댑터로 > mAdapter가 역할을 하도록 연결시키자.
        studentListView.adapter = mAdapter


//        리스트뷰의 각 줄이 눌렸을 때 이벤트 처리
        studentListView.setOnItemClickListener { adapterView, view, position, l ->

//            세번째 변수 : position or i → 어느 줄이 눌렸는지, 줄의 위치를 알려줌

//            Log.d("리스트뷰눌린줄", position.toString())
//            position을 가지고 > 클릭된 사람이 누구인지 가져와야함
            val clickedStudent = mStudentList[ position ]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()

        }

//        리스트뷰의 아이템이 길게 눌렸을 때.

        studentListView.setOnItemLongClickListener { adapterView, view, position, l ->

//            ~~가 길게 눌림. 토스트 출력
            val clickedStudent = mStudentList[position]
            Toast.makeText(this, "${clickedStudent.name}이(가) 길게 눌림", Toast.LENGTH_SHORT).show()

//         마지막에 결과로 true / false 하나 지정 필요.
            return@setOnItemLongClickListener  true

        }


    }
}