package com.example.graphlib_sample;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class GraphViewFragment extends Fragment {
	
	private FrameLayout mBody;
	private GraphView mGraphView;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_graphview, container, false);
		mBody = (FrameLayout) rootView.findViewById(R.id.fl_graph_body);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setGraph();
		setGraphStyle();
	}
	
	private void setGraph() {
		if( mBody == null )
			return;
				
		GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
				new GraphViewData(1,  2.0d),
				new GraphViewData(2, 1.5d),
				new GraphViewData(3, 2.5d),
				new GraphViewData(4, 1.0d)
		});
				
		mGraphView = new LineGraphView(getActivity(), "GraphViewDemo");
		mGraphView.addSeries(exampleSeries);				
		
		mGraphView.setManualMaxY(true);
		mGraphView.setManualYAxisBounds(10, 0);
				
		mBody.addView(mGraphView);
	}
	
	private void setGraphStyle() {
		mGraphView.getGraphViewStyle().setGridColor(Color.GREEN);
//		mGraphView.getGraphViewStyle().setHorizontalLabelsColor(Color.YELLOW);
//		mGraphView.getGraphViewStyle().setVerticalLabelsColor(Color.RED);
//		mGraphView.getGraphViewStyle().setTextSize(getResources().getDimension(R.dimen.big));
//		mGraphView.getGraphViewStyle().setNumHorizontalLabels(5);
//		mGraphView.getGraphViewStyle().setNumVerticalLabels(4);
//		mGraphView.getGraphViewStyle().setVerticalLabelsWidth(300);
	}
}
