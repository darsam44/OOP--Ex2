package algorithms;

import java.util.List;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
	private int edgeSize =0;
	private graph graph ;
	private int NodeSize =0;

	
	
	@Override
	public void init(graph g) {
		this.edgeSize= g.edgeSize();
		this.NodeSize=g.nodeSize();
		this.graph=g;
		
	}

	@Override
	public void init(String file_name) {
		
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		
		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	//not finish
	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		 Graph_Algo ans= new Graph_Algo();
		 ans.edgeSize=this.edgeSize;
		 ans.NodeSize=this.NodeSize;
		 ans.graph=this.graph;

		return ans;
	}

}
