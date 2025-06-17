class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        min=-149

        for i in range(0,len(number)):
            if(number[i]==digit):
                check =int(number[:i]+number[i+1:])
                if(check>min ):
                    min=check
        
        return str(min)