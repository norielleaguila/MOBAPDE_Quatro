import bs4
from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup

my_url = 'http://www.dlsu.edu.ph/faculty/fis/fis_start.asp?deptcode=CHE'
#my_url2 = 'http://www.dlsu.edu.ph/faculty/fis/fis_start.asp?deptcode=IT'
# Opening up connection, grabbing the page
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()

#html parsing
page_soup = soup(page_html, "html.parser")

#grabs each product
containers = page_soup.findAll("div", {"id": "click_details"})

filename = "che.csv"
f = open(filename, "w")
headers = "Name, Title, Department\n"
f.write(headers)

for container in containers:
    professor_container = container.findAll("span", {"id":"fac_name"})
    title_container = container.find("span", id=False, class_=False)
    professor_name = professor_container[0].text
    title_array = title_container.text
    title_array = title_array.split(" ")
    professor_title = title_array[0] + " " + title_array[1]
    professor_department =  title_array[len(title_array) - 2] + " " + title_array[len(title_array)-1]

#    title_array[len(title_array) - 3] + " " + title_array[len(title_array) - 2] + " " +

    f.write(professor_name.replace(",","|") + "," +  professor_title + "," + professor_department.replace(",","|") + "\n")
    print("Name: " + professor_name)
    print("Title: " + professor_title)
    print("Department: " + professor_department)
    print("\n\n")






f.close()
