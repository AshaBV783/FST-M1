
import pandas as pd
 
df = pd.read_excel('contacts.xlsx', engine='openpyxl')
 
rows, cols = df.shape
print("Number of rows:", rows)
print("Number of columns:", cols)
 
print("Emails:")
print(df['Email'])
 
sorted_df = df.sort_values(by='FirstName', ascending=True)
print("Sorted by FirstName (ascending):")
print(sorted_df)
