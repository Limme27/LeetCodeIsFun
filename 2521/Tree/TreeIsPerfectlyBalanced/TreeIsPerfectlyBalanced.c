
#include <stdlib.h>
#include <math.h>

#include "tree.h"

int numNodes(Tree t) {
	if (t == NULL) return 0;
	return 1 + numNodes(t->left) + numNodes(t->right);
}

bool TreeIsPerfectlyBalanced(Tree t) {
	// TODO
	if (t == NULL) return true;
	
	if (abs(numNodes(t->left) - numNodes(t->right)) <= 1) 
		return TreeIsPerfectlyBalanced(t->left) && TreeIsPerfectlyBalanced(t->right);

	return false;
}
