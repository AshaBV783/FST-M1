list1 = [10, 21, 4, 45, 66, 93]
list2 = [11, 22, 33, 44, 55, 66]
 
new_list = []
 
for num in list1:
    if num % 2 != 0:
        new_list.append(num)
 
for num in list2:
    if num % 2 == 0:
        new_list.append(num)

print("New List:", new_list)
