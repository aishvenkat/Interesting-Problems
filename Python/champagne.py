
def getVal(level, ind, tot, one):
    arr = [tot]
    st = 0
    l = 1
    while(st < level):
        st += 1
        l += 1
        na = [0] * l
        for j,i in enumerate(arr):
            if i <= one:
                continue
            i -= one
            na[j] += i/2.0
            na[j+1] += i/2.0
        arr = na
    return one if arr[ind] > one else arr[ind]

print getVal(3, 1, 20, 2)
print getVal(2, 0, 14, 2)
print getVal(2, 1, 14, 2)
print getVal(3, 1, 14, 2)
print getVal(3, 2, 14, 2)
print getVal(3, 0, 14, 2)

