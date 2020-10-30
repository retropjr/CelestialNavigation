using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Celestial_Navigation_Calculations
{
    public partial class MeridianAltitudeCalculation : Form
    {
        public MeridianAltitudeCalculation()
        {
            InitializeComponent();
        }



        private void bMainWindow_Click(object sender, EventArgs e)
        {
            new CelestialNavCalcs().Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            double DrLong = CelestialTool.ConvertInput(maskedTextBox1.Text);
            int localTimeZone = int.Parse(numericUpDown1.Text);
            DateTime timeOfMeridianPassageAlmanac = DateTime.Parse(maskedTextBox2.Text);

            double timeToArc = DrLong / 15;
            double timeToArcHours = Math.Floor(timeToArc);
            double timeToArcMinutes = (timeToArc - timeToArcHours) * 60;

            DateTime timeOfMeridianPassageUTC = timeOfMeridianPassageAlmanac.
                                                AddHours(-timeToArcHours).
                                                AddMinutes(-timeToArcMinutes);
            DateTime timeOfMeridianPassageLocal = timeOfMeridianPassageUTC.AddHours(localTimeZone);

            maskedTextBox3.Text = timeOfMeridianPassageUTC.ToString("dd/MM/yyyy HH:mm:ss");
            maskedTextBox4.Text = timeOfMeridianPassageLocal.ToString("dd/MM/yyyy HH:mm:ss");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox10.Text = CelestialTool.CalculateInterpFactor(maskedTextBox4.Text).ToString("N4");
            double interpFactor = Double.Parse(textBox10.Text);

            double DEC0 = CelestialTool.ConvertInput(textBox6.Text);
            if (DEC0 == 111111)
            {
                textBox6.Text = "Input?";
            }
            double DEC1 = CelestialTool.ConvertInput(textBox7.Text);
            if (DEC1 == 111111)
            {
                textBox7.Text = "Input?";
            }

            double DEC = DEC0 + (interpFactor * (DEC1 - DEC0));
            double h = Double.Parse(textBox3.Text);
            double D = 0.0293 * Math.Sqrt(h);
            double HS = CelestialTool.ConvertInput(textBox5.Text);
            if (HS == 111111)
            {
                textBox5.Text = "Input?";
            }
            double I = CelestialTool.ConvertInput(textBox4.Text);
            if (I == 111111)
            {
                textBox4.Text = "Input?";
            }
            double H = HS + I - D;
            double Hrad = H * Math.PI / 180;
            double sd = Double.Parse(textBox8.Text);
            double SD = sd / 60;
            double Hcalc = (H + (7.32 / (H + 4.32))) * Math.PI / 180;
            double temp = Double.Parse(numericUpDown2.Text);
            double pressure = Double.Parse(numericUpDown3.Text);
            double f = (0.28 * pressure) / (temp + 273);
            double refractionConstant = 0.0167 * Math.PI / 180;
            double Rrad = refractionConstant / Math.Tan(Hcalc);
            double Ro = Rrad / (Math.PI / 180);
            double R = f * Ro;
            double HP = 0.0024;
            double HPrad = HP * Math.PI / 180;
            double PArad = HPrad * Math.Cos(Hrad);
            double PA = PArad / (Math.PI / 180);

            double HO = H - R + PA + SD;

            double MZD = 90 - HO;

            string nameOfMZD = CelestialTool.NameOfMZD(checkBox1.Checked);

            string nameOfDEC = CelestialTool.NameOfDEC(DEC);

            double lattitudeDec = CelestialTool.CalculateLattitude(MZD, DEC, nameOfMZD, nameOfDEC);

            string lattitudeHemisphere = CelestialTool.CalculateHemisphere(MZD, DEC, nameOfMZD, nameOfDEC);

            double lattitudeDegree = Math.Floor(lattitudeDec);
            double lattitudeMinute = (lattitudeDec - lattitudeDegree) * 60;

            textBox9.Text = lattitudeDegree.ToString() + " " + lattitudeMinute.ToString("N1") + " " +
                            lattitudeHemisphere;


        }

    }
  
}
