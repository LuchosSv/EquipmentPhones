package com.example.iphone.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iphone.R
import com.example.iphone.adapters.PhabletAdapter
import com.example.iphone.adapters.TabletAdapter
import com.example.iphone.adapters.iPhoneAdapter
import com.example.iphone.interfaces.ActivityListener
import com.example.iphone.interfaces.OnClickListener
import com.example.iphone.models.EquipmentDetail
import com.example.iphone.models.GeneralInfo
import java.lang.Exception
import java.util.ArrayList

class ShowListEquipment : Fragment(), OnClickListener {

    private lateinit var recycleView: RecyclerView
    private lateinit var recycleViewTablet: RecyclerView
    private lateinit var recycleViewPhablet: RecyclerView
    private var listener: ActivityListener? = null
    private var iPhoneList = arrayListOf<EquipmentDetail>()
    private var TabletList = arrayListOf<EquipmentDetail>()
    private var PhabletList = arrayListOf<EquipmentDetail>()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as ActivityListener
            Log.e("Exito", "Todo bien")
        }catch (e: Exception){
            Log.e("EquipmentListFragment", "Activity is not compatible", e)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_list_equipment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleView = view.findViewById(R.id.recycleView)
        recycleViewTablet = view.findViewById(R.id.recycleViewTablet)
        recycleViewPhablet = view.findViewById(R.id.recycleViewPhablet)
        iPhoneList = getiPhoneList()
        TabletList = getTabletList()
        PhabletList = getPhablettList()
        recycleView.adapter = iPhoneAdapter(iPhoneList, this)
        recycleViewTablet.adapter = TabletAdapter(TabletList, this)
        recycleViewPhablet.adapter = PhabletAdapter(PhabletList, this)

    }

    private fun getiPhoneList(): ArrayList<EquipmentDetail> {
        return arrayListOf(
            EquipmentDetail(
                "iPhone 11 pro",
                2020,
                9999.9,
                GeneralInfo(
                    "https://images.pexels.com/photos/3707744/pexels-photo-3707744.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                    500,
                    "USA, China"
                )
            ),
            EquipmentDetail(
                "iPhone X",
                2019,
                5899.9,
                GeneralInfo(
                    "https://images.pexels.com/photos/968639/pexels-photo-968639.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                    500,
                    "USA, China"
                )
            ),
            EquipmentDetail(
                "huawei y9 2019",
                2020,
                400.0,
                GeneralInfo(
                    "https://ae01.alicdn.com/kf/HTB1ao4PXOjrK1RjSsplq6xHmVXaB/Para-Huawei-Y9-2019-funda-de-lujo-de-cristal-templado-brillante-marco-de-silicona-suave-cubierta.jpg",
                    250,
                    "China"
                )
            ),
            EquipmentDetail(
                "xiamoi redmi note 8",
                2018,
                799.9,
                GeneralInfo(
                    "https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2019/10/xiaomi-redmi-note-8-pro_14.jpg",
                    450,
                    "Usa, China"
                )
            ),
            EquipmentDetail(
                "Generico YX",
                2019,
                99.9,
                GeneralInfo(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTK5Ni1Q90cyUMz6Kt9uSM1ExN19OXgquiigr2ttFj7qhYlntkr",
                    100,
                    "El Salvador"
                )
            )
        )
    }

    private fun getTabletList(): ArrayList<EquipmentDetail> {
        return arrayListOf(
            EquipmentDetail(
                "Microsoft Surface Pro 6",
                2019,
                5999.9,
                GeneralInfo(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQHHDHSSWbIE9lnnzwwbvwlhJgwWGxo7LC0W7D9v3tKlXTXk-N8",
                    500,
                    "USA"
                )
            ),
            EquipmentDetail(
                "iPad ",
                2018,
                2699.9,
                GeneralInfo(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRRx3qe9YgEm7vtx6_q9gVrH84e2DRS0fDG5yfQ4JakrJe7yuLc",
                    250,
                    "USA, China, Mexico"
                )
            ),
            EquipmentDetail(
                "Amazon Fire HD 8",
                2018,
                3259.9,
                GeneralInfo(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTvUf65p_3otEQ-1mUaEioyjL8ISAcIzkYyXltZDnRtWrGA6ADO",
                    250,
                    "USA, China, Mexico"
                )
            ),
            EquipmentDetail(
                "Huawei MediaPad T5",
                2016,
                1259.9,
                GeneralInfo(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTwXX4H4RssOL3TagAkwgC3nZmszdD_wjE0Bd9Hn3aHL2c5LihX",
                    125,
                    "USA, China, Mexico"
                )
            ),EquipmentDetail(
                "Tablet Generica 2.0",
                2018,
                3259.9,
                GeneralInfo(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT3w9bCCPm2Z838zxY5Lf7gqh-U9tJGN95XjPneEXsu8_qrUnW-",
                    68,
                    "USA, China, Mexico, El Salvador"
                )
            )
        )
    }

    private fun getPhablettList(): ArrayList<EquipmentDetail> {
        return arrayListOf(
            EquipmentDetail(
                "Galaxy Note 10",
                2018,
                4699.9,
                GeneralInfo(
                    "https://static-geektopia.com/storage/t/p/101/101884/784x314/galaxy-note-10.jpg",
                    300,
                    "USA, Mexico, Corea del Sur"
                )
            ),
            EquipmentDetail(
                "Pixel 4 de Google",
                2016,
                289.9,
                GeneralInfo(
                    "https://r3.whistleout.com.mx/public/images/articles/2019/10/google-pixel-4.jpg",
                    100,
                    "USA"
                )
            ),
            EquipmentDetail(
                "Samsung Galaxy Fold",
                2017,
                3999.9,
                GeneralInfo(
                    "https://cnet4.cbsistatic.com/img/BZhOgzaNcsc8fVQJmML9334-S-8=/2019/12/21/08bc2882-f90d-44b8-92e9-f5cf67f5db4d/samsung-galaxy-fold.jpg",
                    300,
                    "USA, Corea del Sur"
                )
            ),
            EquipmentDetail(
                "Galaxy S10 y S10+ de Samsung",
                2014,
                874.9,
                GeneralInfo(
                    "https://static-geektopia.com/storage/t/p/983/98319/784x314/samsung_galaxy_s10.jpg",
                    150,
                    "USA, Corea del Sur"
                )
            ),
            EquipmentDetail(
                "Zenfone 6 de ASUS",
                2018,
                647.9,
                GeneralInfo(
                    "https://static-geektopia.com/storage/t/p/104/104419/784x314/zenfone-6.jpg",
                    24,
                    "El Salvador, Chile, Argentina, Nicaragua"
                )
            )
        )
    }

    override fun clickImage(equipmentDetail: EquipmentDetail) {
        val fragment = ShowDetailEquipment.newInstance(equipmentDetail)
        listener?.loadFragment(fragment)
    }

}
