using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace Lab11
{
    class Strong
    {
        private BigInteger n;

        public Strong(BigInteger N)
        {
            n = N;
        }

        public BigInteger Number { get => n; set => n= value; }

        public BigInteger calculate()
        {
            BigInteger start = 1;
            BigInteger result=1;
            if (n > 0)
            {
                while (start <= n)
                {
                    result *= start;
                    ++start;
                }
            }
            else
            {
                Console.WriteLine("Wrong argument n!");
                result = -1;
            }
            return result;
        }

        public void print_in_scientific_notation(BigInteger result)
        {
            string sn = result.ToString();
            int lenght = sn.Length;
             Console.WriteLine(sn + " " + lenght);
            if (lenght>4)
            {
                Console.WriteLine("Result: "+sn[0]+sn[1] + "," + sn[2] + sn[3] + " 10E" + (lenght - 2));
            }
            else
            {
                Console.WriteLine(sn);
            }
        }

    }
}
