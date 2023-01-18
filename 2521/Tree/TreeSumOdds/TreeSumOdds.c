
#include <stdlib.h>

#include "tree.h"

int TreeSumOdds(Tree t) {
	if (t == NULL) return 0;

	if (t->value % 2 == 1) 
		return t->value + TreeSumOdds(t->left) + TreeSumOdds(t->right);
	// t->value % 2 == 0
	return TreeSumOdds(t->left) + TreeSumOdds(t->right);
}

