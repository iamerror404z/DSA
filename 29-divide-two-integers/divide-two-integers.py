class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if ((dividend==-2147483648) and (divisor==-1)):
            return 2147483647
        if dividend<0 and divisor>0 :
            dividend=dividend*-1
            c=dividend//divisor
            return (-c)
        elif divisor<0 and dividend>0 :
            divisor=divisor*-1
            c=dividend//divisor
            return (-c)
        elif dividend<0 and divisor<0:
            c=dividend//divisor
            return (c)
            
        else:
            c=dividend//divisor
            return (c)
        