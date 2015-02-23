using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;
using System.Windows.Forms;

namespace MijnEigenBrowser
{

    public partial class BrowserForm : Form
    {
        private const int MIN_PROGRESS = 0;
        private const int MAX_PROGRESS = 10;
        private const int STEP_PROGRESS = 1;
        private int navigatingDocs = 0; 
        private System.Timers.Timer prgTimer = null;

        public BrowserForm()
        {
            InitializeComponent();

            //Initialize the browser with the start page
            myBrowser.Navigating += new WebBrowserNavigatingEventHandler(myBrowser_Navigating);
            myBrowser.Navigated += new WebBrowserNavigatedEventHandler(myBrowser_Navigated);
            GoToURL("http://google.com");
        }

        private void GoToURL(string url)
        {
            tbURL.Text = url;
            myBrowser.Navigate(url);
            tbURL.Enabled = false;
            btnGO.Enabled = false;
        }

        private void StartProgress()
        {
            if (navigatingDocs == 0)
            {

                rpbBrowser.Minimum = MIN_PROGRESS;
                rpbBrowser.Maximum = MAX_PROGRESS;
                rpbBrowser.Value = MIN_PROGRESS;
                prgTimer = new System.Timers.Timer(100);
                prgTimer.Elapsed += OnProgressTimedEvent;

                prgTimer.Enabled = true;
                rpbBrowser.Enabled = true;
                prgTimer.Start();
            }

            navigatingDocs++;
            lblDocsNav.Text = navigatingDocs.ToString();
        }

        private void IncrementProgress()
        {
            if( rpbBrowser.Enabled )
            {
                rpbBrowser.Value = ((rpbBrowser.Value + STEP_PROGRESS) % MAX_PROGRESS) + 1;
            }
        }

        private void StopProgress()
        {
            navigatingDocs = 0;
            lblDocsNav.Text = navigatingDocs.ToString();

            prgTimer.Stop();
            prgTimer.Enabled = false;
            rpbBrowser.Value = MIN_PROGRESS;
            rpbBrowser.Enabled = false;
        }

        private void OnProgressTimedEvent(Object source, ElapsedEventArgs e)
        {
            Invoke(new Action(() => IncrementProgress())); 
        }

        private void myBrowser_Navigating(object sender, WebBrowserNavigatingEventArgs e)
        {
            StartProgress();
        }

        private void myBrowser_Navigated(object sender, WebBrowserNavigatedEventArgs e)
        {
            StopProgress();

            tbURL.Text = myBrowser.Url.ToString();
            tbURL.Enabled = true;
            btnGO.Enabled = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (!myBrowser.Url.ToString().Equals(tbURL.Text))
            {
                PreviousWebPage oldPage = new PreviousWebPage(myBrowser.Url.ToString());
                oldPage.Show();

                myBrowser.Navigate(tbURL.Text);
            }
        }
    }
}
