class Solution:
    def ipv4(self,IP:str) -> str:
        if(IP=="0.0.0.0"):
            return "IPv4"
        lst=list(IP.split("."))
        if(len(lst))!=4:
            return "Neither"
        for i in lst:
            if (len(i)>3 or len(i)<=0):
                return "Neither"
            if (len(i)>1 and i[0]=="0"):
                return "Neither"
            try:
                c=int(i)
                if(c<0 or c>255):
                    return "Neither"
            except:
                return "Neither"

        return "IPv4"

    def ipv6(self,IP:str) -> str:
        lst=list(IP.split(":"))
        if(len(lst)!=8):
            return "Neither"

        for  i in lst:
            if(len(i)>4 or len(i)<1):
                return "Neither"
            for j in i:
                loc=ord(j)
                check_point1=not(loc>=48 and loc<=57)
                check_point2=not(loc>=65 and loc<=70)
                check_point3=not(loc>=97 and loc<=102)
                print(check_point1,"vs",check_point2,"vs",check_point3)
                if(check_point1 and check_point2 and check_point3):
                    print(j)
                    return "Neither"


        return "IPv6"
    
    def validIPAddress(self, queryIP: str) -> str:
        for i in queryIP:
            #print(i)
            if i=='.':
                return self.ipv4(queryIP)
            elif(i==':'):
                return self.ipv6(queryIP)
        else:
            return "Neither"
