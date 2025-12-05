user_input = input("Enter numbers separated by spaces: ")
 
numbers = list(map(int, user_input.split()))

total_sum = sum(numbers)

print(f"The sum of the elements in the list is: {total_sum}")