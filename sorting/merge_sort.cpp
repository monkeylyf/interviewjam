/*
 * Merge sort in cpp.
 *
 */


#include <stdio.h>
#include <vector>

using std::vector;

typedef std::vector<int>::const_iterator const_it;
typedef std::vector<int>::iterator it;


template<typename T>
int length_of_vector(vector<T> & vect) {
    return sizeof(vect) / sizeof(T);
}


void print_vector(vector<int> vect) {
    for (vector<int>::const_iterator i = vect.begin(); i != vect.end(); ++i) {
        printf("%d ", *i);
    }
    printf("\n");
}


template <class T> class mergeSort {

    public:

    static void merge_sort_vector(vector<T> & vect) {
        if (vect.size() <= 1) {
            return;
        }

        // To sipangzi, if I uncomment the next line and replace it with the
        // second line, it gives me segmentation fault. Why? What's the magic with
        // size_type?
        //int mid = length_of_vector(vect) / 2;
        typename std::vector<T>::size_type mid = vect.size() / 2;
        typename std::vector<T> left (vect.begin(), vect.begin() + mid);
        typename std::vector<T> right (vect.begin() + mid, vect.end());

        merge_sort_vector(left);
        merge_sort_vector(right);

        merge(left.begin(), left.end(), right.begin(), right.end(), vect.begin());
    }

    static void merge(const_it left, const_it left_end, const_it right, const_it right_end, it orig) {
        while (left != left_end && right != right_end) {
            if (*left > *right) {
                *orig = *right;
                ++right;
            } else {
                *orig = *left;
                ++left;
            }
            ++orig;
        }

        merge_all(left, left_end, orig);
        merge_all(right, right_end, orig);
    }

    static T* merge_sort_array(T* array) {
        return array;
    }

    private:

    static void merge_all(const_it begin, const_it end, it orig) {
        while (begin != end) {
            *orig = *begin;
            ++begin;
            ++orig;
        }
    }

};


int main() {
    vector<int> vect {2, 3, 2, 1, 5, -1, 0};

    printf("Before sort: ");
    print_vector(vect);

    mergeSort<int>::merge_sort_vector(vect);
    printf("After sort: ");
    print_vector(vect);
}
