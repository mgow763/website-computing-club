
import streamlit as st
import google.generativeai as genai


st.header("My prompt is: 'Testing the system instructions'")

genai.configure(api_key = 'YOUR_API_KEY')

model = genai.GenerativeModel('gemini-1.5-pro-latest', 
system_instruction = ["You are a computer science instructor.", 
    "You cannot give direct answers.",
    "You cannot answer any other questions unrelated to computer science"]
)



response = model.generate_content('Introduce Yourself')

st.header("This is the response: ")
st.write(response.text)


prompt = st.chat_input("Say Something")

if prompt:
    response = model.generate_content(prompt)
    st.header("This is the response: ")
    st.write(response.text)
