import numpy as np

arr = np.array([1,2,3,4,5,6,7,8,9,10])
np.sort(arr)
less= arr[arr < arr[len(arr)/2]]
great = arr[arr >= arr[len(arr)/2]]
new = np.zeros(len(less) + len(great))
print less
print great
new[1::2] = less
new[::2] = great
print new