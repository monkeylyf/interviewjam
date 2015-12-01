/*
 * Merge sort in cpp.
 *
 */


#include <stdio.h>
#include <vector>

using std::vector;


void print_vector(vector<int> vect) {
    for (vector<int>::const_iterator i = vect.begin(); i != vect.end(); ++i) {
        printf("%d ", *i);
    }
    printf("\n");
}


class mergeSort {

    public:

    //template<class T>
    static void merge_sort_vector(vector<int> & vect) {
        if (vect.size() <= 1) {
            return;
        }

        // To sipangzi, if I uncomment the next line and replace it with the
        // second line, it gives me segmentation fault. Why? What's the magic with
        // size_type?
        //int mid = length_of_vector(vect) / 2;
        std::vector<int>::size_type mid = vect.size() / 2;
        vector<int> left (vect.begin(), vect.begin() + mid);
        vector<int> right (vect.begin() + mid, vect.end());

        merge_sort_vector(left);
        merge_sort_vector(right);

        //print_vector(left);
        //print_vector(right);

        vector<int>::const_iterator i = left.begin();
        vector<int>::const_iterator j = right.begin();
        vector<int>::iterator orig = vect.begin();

        while (i != left.end() && j != right.end()) {
            if (*i > *j) {
                *orig = *j;
                ++j;
            } else {
                *orig = *i;
                ++i;
            }
            ++orig;
        }

        while (i != left.end()) {
            *orig = *i;
            ++i;
            ++orig;
        }

        while (j != right.end()) {
            *orig = *j;
            ++j;
            ++orig;
        }
    }

    static int* merge_sort_array(int* array) {
        return array;
    }

};


template<class T>
int length_of_vector(vector<T> & vect) {
    return sizeof(vect) / sizeof(T);
}


int main() {
    vector<int> vect {2, 3, 2, 1, 5, -1, 0};

    printf("Before sort: ");
    print_vector(vect);

    mergeSort::merge_sort_vector(vect);
    printf("After sort: ");
    print_vector(vect);
}
