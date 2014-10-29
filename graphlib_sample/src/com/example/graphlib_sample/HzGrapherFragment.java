package com.example.graphlib_sample;

import java.util.ArrayList;
import java.util.List;

import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraph;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraphVO;
import com.jjoe64.graphview.LineGraphView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class HzGrapherFragment extends Fragment {

	private FrameLayout mBody;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_hzgrapher,
				container, false);
		mBody = (FrameLayout) rootView.findViewById(R.id.fl_graph_body);
		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		LineGraphVO vo = makeLineGraphDefaultSetting();
				
//		mBody.addView(new LineGraphView(getActivity(), vo));
	}

	private LineGraphVO makeLineGraphDefaultSetting() {

		String[] legendArr = { "1", "2", "3", "4", "5" };
		float[] graph1 = { 500, 100, 300, 200, 100 };
		float[] graph2 = { 000, 100, 200, 100, 200 };
		float[] graph3 = { 200, 500, 300, 400, 000 };

		List<LineGraph> arrGraph = new ArrayList<LineGraph>();
		arrGraph.add(new LineGraph("android", 0xaa66ff33, graph1));
		arrGraph.add(new LineGraph("ios", 0xaa00ffff, graph2));
		arrGraph.add(new LineGraph("tizen", 0xaaff0066, graph3));

		LineGraphVO vo = new LineGraphVO(legendArr, arrGraph);
		return vo;
	}
}
