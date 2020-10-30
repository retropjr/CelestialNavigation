using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Celestial_Navigation_Calculations
{
    class CelestialTool
    {
        public static string PlotAzimuthAndIntercept(double Z, double P)
        {
            string output;

            if (Z < 100)
            {
                output = "Plot 0" + Z.ToString() + "T / " + P.ToString("N1") + "nm";
            }
            else if (Z >= 100)
            {
                output = "Plot " + Z.ToString() + "T / " + P.ToString("N1") + "nm";
            }
            else output = "Error";

            return output;
        }

        public static double ConvertInput(string inputString)
        {
            double input = 0.0;

            string degreesAndMinutes = inputString;
            string sign = inputString.Substring(0, 1);
            string degreesWhole = inputString.Substring(1, 3);
            string minutes = inputString.Substring(5, 4);

            input = double.Parse(degreesWhole);
            double minutesDecimal = double.Parse(minutes);
            double multiplier = +1;

            if ((input >= 0 && input <= 360) &&
               (minutesDecimal >= 0 && minutesDecimal <= 60) &&
                (sign == "+" || sign == "-"))
            {
                if (sign == "-")
                {
                    multiplier = multiplier * -1;
                }
                minutesDecimal = minutesDecimal / 60;
                input = (input + minutesDecimal) * multiplier;
            }
            else
            {
                return 111111;
            }

            return input;
        }

        public static double CalculateInterpFactor(string time)
        {
            double minute = DateTime.Parse(time).Minute;
            double second = DateTime.Parse(time).Second;

            double interpFactor = (minute / 60) + (second / 3600);

            return interpFactor;
        }

        public static string CalculateTimeOfSightUTC(string localTime, string timeZone)
        {
            DateTime timeOfSightLocal = DateTime.Parse(localTime);
            int localTimeZone = int.Parse(timeZone);
            DateTime timeOfSightUTC = timeOfSightLocal.AddHours(-localTimeZone);
            string UTC_Time = timeOfSightUTC.ToString("dd/MM/yyyy HH:mm:ss");

            return UTC_Time;
        }

        public static string NameOfMZD(Boolean n)
        {
            string output;
            if (n)
            {
                output = "S";
            }
            else
            {
                output = "N";
            }
            return output;
        }

        public static string NameOfDEC(double d)
        {
            string output;
            if (d < 0)
            {
                output = "S";
            }
            else
            {
                output = "N";
            }
            return output;
        }

        public static double CalculateLattitude(double m, double d, string nameM, string nameD)
        {
            double output;

            if (nameM == nameD)
            {
                output = Math.Abs(m) + Math.Abs(d);
            }
            else
            {
                if (Math.Abs(m) > Math.Abs(d))
                {
                output = m - Math.Abs(d);
                }
                else
                {
                output = Math.Abs(d) - Math.Abs(m);
                }
            }
            return output;
        }

        public static string CalculateHemisphere(double m, double d, string nameM, string nameD)
        {
            string output;


            if (Math.Abs(m) > Math.Abs(d))
            {
                output = nameM;
            }
            else
            {
                output = nameD;
            }
            return output;
        }

    }
}
