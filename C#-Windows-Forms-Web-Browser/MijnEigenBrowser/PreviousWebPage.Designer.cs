﻿namespace MijnEigenBrowser
{
    partial class PreviousWebPage
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.previousPageBrowser = new System.Windows.Forms.WebBrowser();
            this.SuspendLayout();
            // 
            // previousPageBrowser
            // 
            this.previousPageBrowser.Dock = System.Windows.Forms.DockStyle.Fill;
            this.previousPageBrowser.Location = new System.Drawing.Point(0, 0);
            this.previousPageBrowser.MinimumSize = new System.Drawing.Size(20, 20);
            this.previousPageBrowser.Name = "previousPageBrowser";
            this.previousPageBrowser.Size = new System.Drawing.Size(1021, 530);
            this.previousPageBrowser.TabIndex = 0;
            // 
            // PreviousWebPage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1021, 530);
            this.Controls.Add(this.previousPageBrowser);
            this.Name = "PreviousWebPage";
            this.Text = "PreviouisWebPage";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.WebBrowser previousPageBrowser;
    }
}