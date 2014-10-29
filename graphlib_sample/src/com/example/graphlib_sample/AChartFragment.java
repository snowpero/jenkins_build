package com.example.graphlib_sample;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class AChartFragment extends Fragment {

	private GraphicalView mGraphicalView;
	private FrameLayout mBody;
	
	private XYMultipleSeriesDataset mDataSet = new XYMultipleSeriesDataset();
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	private XYSeries mCurrentSeries;
	private XYSeriesRenderer mCurrentRenderer;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_achart, container, false);
		mBody = (FrameLayout) rootView.findViewById(R.id.fl_graph_body);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setGraph();
	}
	
	private void setGraph() {	
				
		if(mGraphicalView == null) {
			mCurrentSeries = new XYSeries("Sample Data");
			mDataSet.addSeries(mCurrentSeries);
			mCurrentRenderer = new XYSeriesRenderer();
			mRenderer.addSeriesRenderer(mCurrentRenderer);
			
			initData();
			mGraphicalView = ChartFactory.getCubeLineChartView(getActivity(), mDataSet, mRenderer, 0.3f);
			if( mBody != null )
				mBody.addView(mGraphicalView);
		} else {
			mGraphicalView.repaint();
		}
	}
	
	private void initData() {
		mCurrentSeries.add(1, 2);
		mCurrentSeries.add(2, 3);
		mCurrentSeries.add(3, 2);
		mCurrentSeries.add(4, 5);
		mCurrentSeries.add(5, 4);
	}
}
