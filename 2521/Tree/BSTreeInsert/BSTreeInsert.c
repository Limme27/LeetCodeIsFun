
#include <stdio.h>
#include <stdlib.h>

#include "BSTree.h"

static BSTree newNode(int val) {
	BSTree new = malloc(sizeof(*new));
	new->value = val;
	new->left = NULL;
	new->right = NULL;
	return new;
}
// DFS
BSTree BSTreeInsert(BSTree t, int val) {
	// TODO
	// empty tree or a leaf node
	if (t == NULL) return newNode(val);
	// go left	
	if (val < t->value) {
		t->left = BSTreeInsert(t->left, val);
		return t;
	// go right	
	} else if (val > t->value) {
		t->right = BSTreeInsert(t->right, val);
		return t;
	// if (val == t->value)
	} else {
		return t;
	}
}

