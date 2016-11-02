string = raw_input("Enter a string: ")
i = 0
size = len(string)
prev = string[0]
count = 0
newstring = ""
while i < size:
    if string[i] != prev:
        newstring += prev + str(count)
        prev = string[i]
        count = 0
    i += 1
    count += 1
newstring += prev + str(count)
print newstring
