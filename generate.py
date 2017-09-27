#!coding=utf-8
import codecs, time, sys, os, traceback, re
from selenium import webdriver
from selenium.webdriver.support.select import Select

BASE_DIR = os.path.abspath(os.path.dirname(__file__))
BASE_URL = "https://leetcode.com"

def generateProblemPackage(name, code = None, description = None):

    problemDir = os.path.join(os.path.join(BASE_DIR, "src"), name)
    print("Creating package at:%s" % problemDir)
    if not os.path.exists(problemDir):
        os.mkdir(problemDir)
    readmeName = os.path.join(problemDir, "Readme.md")
    if not os.path.exists(readmeName):
        readme = codecs.open(filename=readmeName, mode="w", encoding="utf-8")
        if description:
            readme.write(description)
        readme.close()
    solutionName = os.path.join(problemDir, "Solution.java")
    if not os.path.exists(solutionName):
        solution = codecs.open(filename=solutionName, mode="w", encoding="utf-8")
        if code:
            solution.write(code)
        solution.flush()
        solution.close()

def getProblemPage(argv, codeLang = "java"):
    url = BASE_URL + "/problems/" + "-".join(argv).lower() + "/description/"
    print("Start to get infomation from %s" % url)
    service_args = [
        # '--proxy=127.0.0.1:1080',
        # '--proxy-type=socks5',
    ]
    try:
        # browser = webdriver.Chrome(os.path.join("browser", "chromedriver.exe"))
        browser = webdriver.PhantomJS(executable_path=os.path.join("browser", "phantomjs.exe"), service_args=service_args)
        browser.get(url)
        description = browser.find_element_by_class_name("question-description").text
        print("Description:%s..." % description[0:10])
        lang = Select(browser.find_element_by_name("lang"))
        lang.select_by_value(codeLang)
        browser.refresh()
        code = browser.find_element_by_name("lc-codemirror").get_attribute("value")
        print("Code of %s:\r\n%s" % (codeLang, code))
        browser.quit()
    except:
        traceback.print_exc()
        exit(0)


    if codeLang == "java":
        packageName = "_".join(argv)
        if re.match("^\d.*", packageName):
            packageName = "_" + packageName
        code = "package %s;\r\n" \
               "public %s\r\n" \
               "\tpublic static void main(String[] args) {\r\n" \
               "\t\tSolution s = new Solution();\r\n\t}\r\n}" % (packageName, code[:-1])
        description = description.replace("Input", "```\r\nInput").replace("Note", "```\r\nNote")

        generateProblemPackage(packageName, code=code, description=description)

if __name__ == "__main__":
    if (len(sys.argv) < 2):
        print("Usage:python3 generate.py [problem name]")
        exit(0)
    getProblemPage(sys.argv[1:])