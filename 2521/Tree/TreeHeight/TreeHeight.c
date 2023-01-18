
#include <stdlib.h>

#include "tree.h"

int TreeHeight(Tree t) {
    if (t == NULL) return -1;
    if (t->left == NULL && t->right == NULL) return 0;

    int lh = 1 + TreeHeight(t->left);
    int rh = 1 + TreeHeight(t->right);
    return ((lh > rh) ? lh : rh);
}

