
import pandas as pd
 
df = pd.read_csv("users.csv")    
print("Columns:", list(df.columns))
print(df.head(), "\n")
 
print("Usernames column values:")
print(df["Usernames"].to_list())    
print()

 
second_row_username = df.iloc[1]["Usernames"]
second_row_password = df.iloc[1]["Passwords"]
print("Second row -> Username:", second_row_username, "| Password:", second_row_password)
print()


print("Usernames sorted ascending:")
print(df["Usernames"].sort_values(ascending=True).to_list())
print()

 
print("Passwords sorted descending:")
print(df["Passwords"].sort_values(ascending=False).to_list())
print()

 
df_sorted_by_user = df.sort_values("Usernames", ascending=True)
print("DataFrame sorted by Usernames (ascending):")
print(df_sorted_by_user)
print()
 
df_sorted_by_pass = df.sort_values("Passwords", ascending=False)
print("DataFrame sorted by Passwords (descending):")
print(df_sorted_by_pass)
