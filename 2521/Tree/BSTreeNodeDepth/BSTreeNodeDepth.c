
#include <stdlib.h>

#include "BSTree.h"

int BSTreeNodeDepth(BSTree t, int key) {
	if (t == NULL) return -1;
	if (key == t->value) return 0;
	if (key < t->value) {
		int depth = BSTreeNodeDepth(t->left, key);
		if (depth >= 0) return depth + 1;
	}
	if (key > t->value) {
		int depth = BSTreeNodeDepth(t->right, key);
		if (depth >= 0) return depth + 1;
	}
	// default return is -1 as long as it's not found
	// will return 0 or above if it's found
	return -1;
}

	