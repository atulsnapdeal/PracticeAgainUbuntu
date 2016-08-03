package com.snapdeal;

import java.util.LinkedList;

public class DepthFirstSearch {
	int V;
	LinkedList<Integer> linkedList[];
	
	DepthFirstSearch(int v) {
		V = v;
		linkedList = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			linkedList[i] = new LinkedList();
		}
	}
		
	void addEdge(int v, int w) {
		linkedList[v].add(w);
	}
	
	void depthFirstSearch(int source) {
		int visited[] = new int[V];
		
	}

}
