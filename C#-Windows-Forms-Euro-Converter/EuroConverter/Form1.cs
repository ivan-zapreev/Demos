using EuroConverter.Properties;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EuroConverter
{
    public partial class ConverterForm : Form
    {
        private string euroText = "EUR";
        private string dollarText = "USD";
        private string dollarSign = "$";
        private string poundText = "GBP";
        private string poundSign = "\u00A3";
        private string yenText = "YEN";
        private string yenSign = "\u00A5";

        public ConverterForm()
        {
            InitializeComponent();
            cbCurrType.SelectedIndex = 0;
        }

        private void tbEuroCurr_SelectedIndexChanged(object sender, EventArgs e)
        {
            string currName = (string)cbCurrType.Items[cbCurrType.SelectedIndex];
            string imageName = null;
            if (currName == dollarText)
            {
                lbCurrSymb.Text = dollarSign;
                imageName = "dollar";
            } else 
            {
                if (currName == poundText)
                {
                    lbCurrSymb.Text = poundSign;
                    imageName = "pound";
                }
                else
                {
                    if (currName == yenText)
                    {
                        lbCurrSymb.Text = yenSign;
                        imageName = "yen";
                    }
                    else
                    {
                        MessageBox.Show("Non-supported selection: " + currName);
                    }
                }
            }

            if (imageName != null)
            {
                Image image = (Image)Resources.ResourceManager.GetObject(imageName);
                pbToCurr.Image = image;
            }
        }

        private bool validateIntFieldValue(TextBox textBox, string currName) {
            bool result = false;
            if (textBox.Text != null && textBox.Text.Length != 0)
            {
                try
                {
                    double euro = Convert.ToDouble(textBox.Text);
                    result = true;
                }
                catch (System.FormatException)
                {
                    MessageBox.Show("The number of " + currName + " is not a nunber!");
                    textBox.Text = "0";
                }
            }
            else
            {
                MessageBox.Show("The number of " + currName + " is not defined!");
                textBox.Text = "0";
            }
            return result;
        }

        private void btnToOther_Click(object sender, EventArgs e)
        {
            if (validateIntFieldValue(tbEuroCurr, euroText))
            {
                double euroCurr = Convert.ToDouble(tbEuroCurr.Text);
                tbOtherCurr.Text = Convert.ToString(euroCurr * Convert.ToDouble(tudConvCoeff.Value));
            }
        }

        private void btnToEuro_Click(object sender, EventArgs e)
        {
            if (validateIntFieldValue(tbOtherCurr, (string) cbCurrType.Items[cbCurrType.SelectedIndex]))
            {
                double otherCurr = Convert.ToDouble(tbOtherCurr.Text);
                tbEuroCurr.Text = Convert.ToString(otherCurr / Convert.ToDouble(tudConvCoeff.Value));
            }
        }
    }
}
