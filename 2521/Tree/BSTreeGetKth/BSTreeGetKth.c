
#include <stdlib.h>
#include <limits.h>

#include "BSTree.h"
#define INFINITY INT_MAX


static int BSTreeNumNodes(BSTree t) {
    if (t == NULL) return 0;
	return 1 + BSTreeNumNodes(t->left) + BSTreeNumNodes(t->right);	 
}

int BSTreeGetKth(BSTree t, int k) {
	// TODO
	int index = BSTreeNumNodes(t->left);
	if (k < index) return BSTreeGetKth(t->left, k);
	if (k > index) return BSTreeGetKth(t->right, k - index - 1);
	// base case recursive stop point
	return t->value;
}
/*
static int cmpInt(const void *a, const void *b) {
	const int *p1 = a;
	const int *p2 = b;
	// ascending order
	return *p1 - *p2;
}

static int cmpStr(const void *a, const void *b) {
	// ascending order
	return strcmp(a, b);
}
*/