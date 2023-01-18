
#include "tree.h"

static Tree newNode(int val) {
	Tree new = malloc(sizeof(*new));
	new->value = val;
	new->left = NULL;
	new->right = NULL;
	return new;
}

static Tree doTreeCopy(Tree t, int nodeDepth, int depth) {
	if (t != NULL && nodeDepth <= depth) {
		Tree new = newNode(t->value);
		new->left = doTreeCopy(t->left, nodeDepth + 1, depth);
		new->right = doTreeCopy(t->right, nodeDepth + 1, depth);
		return new;
	}
	return NULL;
}

Tree TreeCopy(Tree t, int depth) {
	// TODO
	if (depth < 0 || t == NULL) return NULL;
	return doTreeCopy(t, 0, depth);
}

