using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Lab11
{
    class CountWords
    {
        private StreamReader stream;
        private Dictionary<string, int> cw;

        public CountWords(StreamReader Stream)
        {
            stream = Stream;
            cw = new Dictionary<string, int>();
        }

        public StreamReader Stream { get => stream; set => stream = value; }

        public void read()
        {
            try
            {

                using (var sr = stream)
                {
               
                   var all_words = sr.ReadToEnd();
                   all_words=all_words.ToLower();
                   char[] toDelete = { ' ', ',', '.', ':',';', '\t', '?','-','_','\n','*','!' };

                    foreach (var word in all_words.Split(toDelete))
                    {
                        if (word.Length > 2)
                        {
                            if (!cw.ContainsKey(word))
                            {

                                cw.Add(word, 1);
                            }
                            else
                            {
                                cw[word] += 1;
                            }
                        }
                    }
                }


            }
            catch (IOException e)
            {
                Console.WriteLine("The file could not be read:");
                Console.WriteLine(e.Message);
            }


            int i = 1;
            foreach (var x in cw.OrderByDescending(x=>x.Value).Take(20))
            {
                Console.WriteLine(i+". <" + x.Key + " , " + x.Value+">");
                ++i;
            }




        }
    }
}
