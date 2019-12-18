package dataStructure;


import java.util.Collection;
import java.util.Hashtable;


public class DGraph implements graph{
	//this hash will represents the node
	Hashtable<Integer, node_data> Nodes = new Hashtable<Integer, node_data>();

	/*The function represent an edges by Hashtable<node_data, Hashtable<Integer, edge_data>>   */
	Hashtable<node_data, Hashtable<Integer, edge_data>>  Edge= new Hashtable<node_data, Hashtable<Integer, edge_data>>();

//	public DGraph() {
//		hash.put(NODE.getKey(), NODE);
//	}

	@Override
	public node_data getNode(int key) {
		if (key != 0) {
			return Nodes.get(key);
		}
		return null;
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		node_data Src = Nodes.get(src);
		edge_data edge = Edge.get(Src).get(dest);
		return edge;
	}

	@Override
	public void addNode(node_data n) {
		Nodes ver = (Nodes) n; 
		Nodes.put(n.getKey(), ver);
	}

	@Override
	public void connect(int src, int dest, double w) {
		edge_data edge = new Edges(Nodes.get(src) , Nodes.get(dest), w);
		Hashtable<Integer, edge_data> table= new Hashtable<Integer, edge_data>();
		table.put(dest, edge);
		Edge.put(Nodes.get(src), table );
	}

	@Override
	public Collection<node_data> getV() {
		return Nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return Edge.get(node_id).values();
	}
	
	
	//start from here
	@Override
	public node_data removeNode(int key) {
		/*we will run on the Hashtable of the edges and check for every edge if the source or the dest is 
		   the node of the key that we get*/
		
		
		
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
