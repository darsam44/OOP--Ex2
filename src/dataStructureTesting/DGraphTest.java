package dataStructureTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.Nodes;
import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;

class DGraphTest {

	@Test
	void testGetNode() {
		DGraph d = new DGraph();
		int j=1;
		for(int i=1;i<10;i++ ) { //the key can't be 0  
			Point3D p = new Point3D(j,j,j);
			Nodes n=new Nodes(i,p,i);
			d.addNode(n);
			if(d.getNode(i)!=n) {
				fail("Not the same node");
			}

		}


	}

	@Test
	void testGetEdge() {
		DGraph d = new DGraph();
		int j=1;
		for(int i=1;i<10;i++ ) { //the key can't be 0  
			Point3D p = new Point3D(j,j,j);
			Nodes n=new Nodes(i,p,i);
			d.addNode(n);
		}

		for(int k=1;k<8;k++) { //connected 1->2->3->4->5->6->7->8->9
			d.connect(k, k+1, k);
			if(d.getEdge(k, k+1)!=d.getEdge(k, k+1)) {
				fail("Not the same Edge");
			}

			try {
				d.getEdge(k+1, k);
			}
			catch(Exception e) {

			}
		}

	}

	@Test
	void testAddNode() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<=10000000 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		System.out.println(d.nodeSize());
	}

	@Test
	void testConnect() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<=10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		for(int i =1 ; i <=d.nodeSize() ;i++) {
			d.connect(1, i, i);
			try {
				d.getEdge(1, i);
			}
			catch(Exception e) {
				fail(); //shouldn't throw exception
			}
			if(d.edgeSize()!=i) {
				fail();
			}
		}
	}

	@Test
	void testGetV() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<=10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		DGraph g = new DGraph();
		for (int i =1 ; i<=10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			g.addNode(n);
		}
		//ask is the m and n should be equals
		Collection<node_data>n=g.getV();
		Collection<node_data>m=d.getV();
		if(!n.equals(g.getV())){
			fail();		
		}
		if(!m.equals(d.getV())){
			fail();
		}


	}

	@Test
	void testGetE() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		for(int i =1 ; i <d.nodeSize() ;i++) {
			d.connect(1, i, i);
		}
		DGraph g = new DGraph();
		for (int i =1 ; i<10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			g.addNode(n);
		}
		//connect key 1 to all the edge
		for(int i =1 ; i <g.nodeSize() ;i++) {
			g.connect(1, i, i);
		}
		//ask if n should be equals to m 

		Collection<edge_data>n=g.getE(1);
		Collection<edge_data>m=d.getE(1);
		if(!n.equals(g.getE(1))){
			fail();		
		}
		if(!m.equals(d.getE(1))){
			fail();
		}

	}

	@Test
	void testRemoveNode() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		for(int i =1 ; i <d.nodeSize() ;i++) {
			d.connect(1, i, i);
		}
		d.removeNode(1);
		try {
			d.getNode(1);
		}catch(Exception e){
			//should catch an exception
		}
		int catchs=0;
		for(int i =1 ; i <d.nodeSize() ;i++) {
			try {
				d.getEdge(1, i);
			}catch(Exception e) {
				catchs++;//should catch an exception 
			}
		}
		if(catchs!=(d.nodeSize()-1)) {
			fail();
		}
		
	}

	@Test
	void testRemoveEdge() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		for(int i =1 ; i <d.nodeSize() ;i++) {
			d.connect(1, i, i);
			if(d.getEdge(1, i)!=d.getEdge(1, i)) {
				fail();
			}
			d.removeEdge(1, i);
			try {
				d.getEdge(1, i);
			}catch(Exception e) {
				//should throw exception
				System.out.println("g");
			}
			
		}

	}

	@Test
	void testNodeSize() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		if (d.nodeSize() != 9) {
			fail();
		}
	}

	@Test
	void testEdgeSize() {
		DGraph d = new DGraph();
		int j=1;
		for (int i =1 ; i<10 ;i++){
			Point3D p = new Point3D(j, j, j);
			Nodes n = new Nodes(i , p , i);
			d.addNode(n);
		}
		for(int i =1 ; i <d.nodeSize() ;i++) {
			d.connect(1, i, i);
		}
		//1->2, 1->3, 1->4, 1->5, 1->6, 1->7, 1->8, 1->9
		if(d.edgeSize()!=8) {
			fail();
		}
	}

	@Test
	void testGetMC() {
		fail("Not yet implemented");
	}

}